import { configureStore } from '@reduxjs/toolkit';
import todoReducer from './slices/todoSlice';

// Tạo store với reducer
const store = configureStore({
  reducer: {
    todos: todoReducer, // Thêm slice vào store
  },
  // Tự động tích hợp Redux DevTools và middleware (thunk)
});

export default store;