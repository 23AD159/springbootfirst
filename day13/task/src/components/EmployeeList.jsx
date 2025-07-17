// import React, { useState } from "react";
// import { Link, useNavigate } from "react-router-dom";

// const EmployeeList = ({ employees = [], onUpdate, onDelete }) => {
//   const [editIndex, setEditIndex] = useState(-1);
//   const [editData, setEditData] = useState({
//     name: "",
//     email: "",
//     password: "",
//     userName: "",
//     roleNames: ""
//   });

//   const navigate = useNavigate();

//   const handleLogout = () => {
//     localStorage.removeItem("token");
//     sessionStorage.clear();
//     alert("Logged out successfully!");
//     navigate("/login");
//   };

//   const startEditing = (index, employee) => {
//     setEditIndex(index);
//     setEditData({
//       name: employee.name,
//       email: employee.email,
//       password: employee.password,
//       userName: employee.userName,
//       roleNames: employee.roleNames ? employee.roleNames.join(", ") : ""
//     });
//   };

//   const handleChange = (e) => {
//     setEditData({ ...editData, [e.target.name]: e.target.value });
//   };

//   const saveEdit = () => {
//     const updatedEmployee = {
//       ...employees[editIndex],
//       ...editData,
//       roleNames: editData.roleNames.split(",").map((r) => r.trim())
//     };
//     onUpdate(editIndex, updatedEmployee);
//     setEditIndex(-1);
//   };

//   return (
//     <div style={{ textAlign: "center" }}>
//       <div style={{ textAlign: "right", marginRight: "20px", marginBottom: "10px" }}>
//         <button
//           onClick={handleLogout}
//           style={{ backgroundColor: "#333", color: "white", padding: "6px 12px", border: "none", cursor: "pointer" }}
//         >
//           Logout
//         </button>
//       </div>

//       <h2>Employee Details</h2>
//       <table border="1" style={{ margin: "0 auto" }}>
//         <thead>
//           <tr>
//             <th>ID</th>
//             <th>Name</th>
//             <th>Email</th>
//             <th>Password</th>
//             <th>Username</th>
//             <th>Roles</th>
//             <th>Actions</th>
//           </tr>
//         </thead>
//         <tbody>
//           {employees.length === 0 ? (
//             <tr>
//               <td colSpan="7">No employees yet.</td>
//             </tr>
//           ) : (
//             employees.map((employee, index) => (
//               <tr key={index}>
//                 <td>{employee.empId}</td>
//                 <td>
//                   {editIndex === index ? (
//                     <input
//                       name="name"
//                       value={editData.name}
//                       onChange={handleChange}
//                     />
//                   ) : (
//                     <Link to={`/employee/${employee.empId}/tasks`}>
//                       {employee.name}
//                     </Link>
//                   )}
//                 </td>
//                 <td>
//                   {editIndex === index ? (
//                     <input
//                       name="email"
//                       value={editData.email}
//                       onChange={handleChange}
//                     />
//                   ) : (
//                     employee.email
//                   )}
//                 </td>
//                 <td>
//                   {editIndex === index ? (
//                     <input
//                       name="password"
//                       value={editData.password}
//                       onChange={handleChange}
//                     />
//                   ) : (
//                     employee.password
//                   )}
//                 </td>
//                 <td>
//                   {editIndex === index ? (
//                     <input
//                       name="userName"
//                       value={editData.userName}
//                       onChange={handleChange}
//                     />
//                   ) : (
//                     employee.userName
//                   )}
//                 </td>
//                 <td>
//                   {editIndex === index ? (
//                     <input
//                       name="roleNames"
//                       value={editData.roleNames}
//                       onChange={handleChange}
//                       placeholder="Comma separated"
//                     />
//                   ) : (
//                     employee.roleNames?.join(", ")
//                   )}
//                 </td>
//                 <td>
//                   {editIndex === index ? (
//                     <>
//                       <button
//                         onClick={saveEdit}
//                         style={{ backgroundColor: "green", color: "white", marginRight: "5px" }}
//                       >
//                         Save
//                       </button>
//                       <button onClick={() => setEditIndex(-1)}>Cancel</button>
//                     </>
//                   ) : (
//                     <>
//                       <button
//                         onClick={() => startEditing(index, employee)}
//                         style={{ backgroundColor: "green", color: "white", marginRight: "5px" }}
//                       >
//                         Update
//                       </button>
//                       <button
//                         onClick={() => onDelete(index)}
//                         style={{ backgroundColor: "red", color: "white" }}
//                       >
//                         Delete
//                       </button>
//                     </>
//                   )}
//                 </td>
//               </tr>
//             ))
//           )}
//         </tbody>
//       </table>
//     </div>
//   );
// };

// export default EmployeeList;
import { useState } from 'react';
import { Link, useNavigate } from 'react-router-dom';

function EmployeeList({ employees, onUpdate, onDelete }) {
  const [searchTerm, setSearchTerm] = useState("");
  const navigate = useNavigate();

  // Filtered employee list
  const filteredEmployees = employees.filter((emp) =>
    emp.name.toLowerCase().includes(searchTerm.toLowerCase())
  );

  // Logout function
  const handleLogout = () => {
    localStorage.removeItem("token"); // Remove JWT
    alert("Logged out successfully");
    navigate("/login");
  };

  return (
    <div className="container mt-4">
      <div className="d-flex justify-content-between align-items-center mb-3">
        <h2>Employee List</h2>
        <button className="btn btn-danger" onClick={handleLogout}>Logout</button>
      </div>

      <div className="mb-3">
        <input
          type="text"
          className="form-control"
          placeholder="Search by employee name..."
          value={searchTerm}
          onChange={(e) => setSearchTerm(e.target.value)}
        />
      </div>

      <table className="table table-bordered">
        <thead>
          <tr>
            <th>Emp ID</th>
            <th>Name</th>
            <th>Actions</th>
            <th>Task Options</th>
          </tr>
        </thead>
        <tbody>
          {filteredEmployees.map((emp, index) => (
            <tr key={emp.empId}>
              <td>{emp.empId}</td>
              <td>{emp.name}</td>
              <td>
                <button
                  className="btn btn-warning btn-sm me-2"
                  onClick={() => onUpdate(index, emp)}
                >
                  Update
                </button>
                <button
                  className="btn btn-danger btn-sm"
                  onClick={() => onDelete(index)}
                >
                  Delete
                </button>
              </td>
              <td>
                <Link
                  to={`/employee/${emp.empId}/create-task`}
                  className="btn btn-success btn-sm me-2"
                >
                  Create Task
                </Link>
                <Link
                  to={`/employee/${emp.empId}/view-tasks`}
                  className="btn btn-primary btn-sm"
                >
                  View Tasks
                </Link>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default EmployeeList;
