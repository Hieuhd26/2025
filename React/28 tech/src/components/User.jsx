import React, { useState } from "react";

const User = () => {
  const [number, setNumber] = useState(0);
  const handleClick = () => {
    setNumber(number + 1);
    console.log(number);
  };
  console.log("out: " + number);

  return (
    <div>
      {number}
      <button onClick={handleClick}>Click</button>
    </div>
  );
};

export default User;
