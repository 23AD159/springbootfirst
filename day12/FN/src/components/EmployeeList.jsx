// import React, { useState } from "react";

// const EmployeeList = ({ employees=[], onUpdate, onDelete }) => {
//   const [editIndex, setEditIndex] = useState(-1);
//   const [editName, setEditName] = useState("");
//   const [editEmail, setEditEmail] = useState("");


//   const startEditing = (index, employee) => {
//     setEditIndex(index);
//     setEditName(employee.name);
//     setEditEmail(employee.email);
//   };

//   const saveEdit = () => {
//     onUpdate(editIndex, { name: editName, email: editEmail });
//     setEditIndex(-1);
//   };

//   return (
//     <div style={{ textAlign: "center" }}>
//       <h2>Employee Details</h2>
//       <table border="1" style={{ margin: "0 auto" }}>
//         <thead>
//           <tr>
//             <th>Name</th>
//             <th>Email</th>
//             <th>Actions</th>
//           </tr>
//         </thead>
//         <tbody>
//           {employees.length === 0 ? (
//             <tr>
//               <td colSpan="3">No employees yet.</td>
//             </tr>
//           ) : (
//             employees.map((employee, index) => (
//               <tr key={index}>
//                 <td>
//                   {editIndex === index ? (
//                     <input
//                       value={editName}
//                       onChange={(e) => setEditName(e.target.value)}
//                     />
//                   ) : (
//                     employee.name
//                   )}
//                 </td>
//                 <td>
//                   {editIndex === index ? (
//                     <input
//                       value={editEmail}
//                       onChange={(e) => setEditEmail(e.target.value)}
//                     />
//                   ) : (
//                     employee.email
//                   )}
//                 </td>
//                 <td>
//                   {editIndex === index ? (
//                     <>
//                       <button onClick={saveEdit}>Save</button>
//                       <button onClick={() => setEditIndex(-1)}>Cancel</button>
//                     </>
//                   ) : (
//                     <>
//                       <button onClick={() => startEditing(index, employee)}>Update</button>
//                       <button onClick={() => onDelete(index)}>Delete</button>
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

import React, { useState } from "react";

const EmployeeList = ({ employees=[], onUpdate, onDelete }) => {
  const [editIndex, setEditIndex] = useState(-1);
  const [editName, setEditName] = useState("");
  const [editEmail, setEditEmail] = useState("");


  const startEditing = (index, employee) => {
    setEditIndex(index);
    setEditName(employee.name);
    setEditEmail(employee.email);
  };

  const saveEdit = () => {
    onUpdate(editIndex, { name: editName, email: editEmail });
    setEditIndex(-1);
  };

  return (
    <div style={{ textAlign: "center" }}>
      <h2>Employee Details</h2>
      <table border="1" style={{ margin: "0 auto" }}>
        <thead>
          <tr>
            <th>Name</th>
            <th>Email</th>
            <th>Actions</th>
          </tr>
        </thead>
        <tbody>
          {employees.length === 0 ? (
            <tr>
              <td colSpan="3">No employees yet.</td>
            </tr>
          ) : (
            employees.map((employee, index) => (
              <tr key={index}>
                <td>
                  {editIndex === index ? (
                    <input
                      value={editName}
                      onChange={(e) => setEditName(e.target.value)}
                    />
                  ) : (
                    employee.name
                  )}
                </td>
                <td>
                  {editIndex === index ? (
                    <input
                      value={editEmail}
                      onChange={(e) => setEditEmail(e.target.value)}
                    />
                  ) : (
                    employee.email
                  )}
                </td>
                <td>
                  {editIndex === index ? (
                    <>
                      <button onClick={saveEdit}>Save</button>
                      <button onClick={() => setEditIndex(-1)}>Cancel</button>
                    </>
                  ) : (
                    <>
                      <button onClick={() => startEditing(index, employee)}>Update</button>
                      <button onClick={() => onDelete(index)}>Delete</button>
                    </>
                  )}
                </td>
              </tr>
            ))
          )}
        </tbody>
      </table>
    </div>
  );
};

export default EmployeeList;