import React, { useEffect, useState } from "react";

const Product = () => {
  const limit = 10;
  const [products, setProducts] = useState([]);
  const [quantityPage, setQuantityPage] = useState(0);
  const [activePage, setActivePage] = useState(0);
  useEffect(() => {
    fetch(
      `https://dummyjson.com/todos?limit=${limit}&skip=${limit * activePage}`
    )
      .then((res) => res.json())
      .then((data) => {
        setProducts(data.todos);
        setQuantityPage(Math.ceil(data.total / limit));
      });
  }, [activePage]);

  const handleClick = (e) => {
    setActivePage(e);
  };

  return (
    <>
      {products?.map((product) => (
        <div key={product.id}>
          <h4>Id : {product.id}</h4>
          <div>
            Name:{" "}
            {product.completed ? (
              <span>
                <s>{product.todo}</s>
              </span>
            ) : (
              <span>{product.todo}</span>
            )}
          </div>
        </div>
      ))}
      <ul>
        {[...Array(quantityPage)].map((_, index) => (
          <li
            key={index}
            onClick={() => {
              handleClick(index);
            }}
          >
            {index}
          </li>
        ))}
      </ul>
    </>
  );
};

export default Product;
