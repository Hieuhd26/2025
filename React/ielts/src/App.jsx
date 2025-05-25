import { useState } from "react";
import { ToastContainer, toast } from "react-toastify";

function App() {
  const [work, setWork] = useState("");
  const [todos, setTodos] = useState([]);

  const handleAdd = () => {
    if (todos?.some((item) => item.id === work?.replace(/\s/g, ""))) {
      toast.warn(`Todo has existed`);
      setWork("");
    } else {
      setTodos((pre) => [
        ...todos,
        { id: work?.replace(/\s/g, ""), job: work },
      ]);
      setWork("");
    }
  };

  const handleDelete = (id) => {
    setTodos(pre => pre.filter(item => item.id !== id))
    
  };

  return (
    <>
      <div className="flex flex-col gap-8 justify-center items-center border border-red-600 h-screen">
        <div className="flex gap-8">
          <input
            type="text"
            className="outline-none border border-blue-600 px-3 py-2 w-[400px]"
            value={work}
            onChange={(e) => setWork(e.target.value)}
          />
          <button
            className="outline-none bg-blue-400 px-3 py-2 rounded-md text-white"
            onClick={handleAdd}
          >
            Add
          </button>
        </div>
        <div>
          <h3 className="font-bold">Content</h3>
          <ul>
            {todos?.map((item) => (
              <li key={item.id} className="flex gap-4 items-center">
                <span className="my-4">{item.job}</span>
                <span
                  onClick={() => handleDelete(item.id)}
                  className="cursor-pointer"
                >
                  X
                </span>
              </li>
            ))}
          </ul>
        </div>
      </div>
      <ToastContainer />
    </>
  );
}

export default App;
