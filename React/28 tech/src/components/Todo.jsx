// useEffect thuc hien sau khi component render giao dien, uu tien render gioa dien roi moi tinh toan logic
// vi sau tu khoa return khong viet dc cai gi nua
import React, { useEffect } from "react";

const Todo = () => {
  useEffect(() => {
    let todos = document.querySelectorAll("ul li");
    console.log(todos);
  });

  return (
    <>
      <ul>
        <li>1</li>
        <li>2</li>
        <li>3</li>
      </ul>
    </>
  );
};

export default Todo;
