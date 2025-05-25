import { createSlice } from '@reduxjs/toolkit';

// Khởi tạo state
const initialState = [
  { id: 1, text: 'Learn React', completed: false },
];

// Tạo slice
const todoSlice = createSlice({
  name: 'todos', // Tên slice
  initialState,
  reducers: {
    // Action: Thêm todo
    addTodo: (state, action) => {
      const newTodo = {
        id: Date.now(),
        text: action.payload,
        completed: false,
      };
      state.push(newTodo); // Immer giúp "mutate" an toàn
    },
    // Action: Xóa todo
    deleteTodo: (state, action) => {
      return state.filter(todo => todo.id !== action.payload);
    },
    // Action: Toggle trạng thái completed
    toggleTodo: (state, action) => {
      const todo = state.find(todo => todo.id === action.payload);
      if (todo) todo.completed = !todo.completed;
    },
  },
});

// Export actions để sử dụng trong component
export const { addTodo, deleteTodo, toggleTodo } = todoSlice.actions;

// Export reducer để thêm vào store
export default todoSlice.reducer;