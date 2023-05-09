import { createContext,  useReducer } from "react";

export const AuthContext = createContext();

const userReducer = (state, action) => {
  switch (action.type) {
    case "LOGIN":
      sessionStorage.setItem('user',JSON.stringify(action.payload))
      return {user: action.payload}
    case "LOGOUT":
      sessionStorage.clear()
      return {user:null}
    default:
      return state
  }
}

export const AuthContextProvider = ({ children }) => {
  const [state, dispatch] = useReducer(userReducer, {
    user:null
  })
  const user = JSON.parse(sessionStorage.getItem('user'))||null

  return (
    <AuthContext.Provider value={{ data:{user}, dispatch }}>
      {children}
    </AuthContext.Provider>
  );
};