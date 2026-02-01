import { configureStore } from '@reduxjs/toolkit'
import valentineReducer from './valentineSlice'

export const store = configureStore({
  reducer: {
    valentine: valentineReducer,
  },
})
