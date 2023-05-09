import './App.scss'
import Register from './pages/Register/Register'
import { createBrowserRouter, Navigate, Outlet, RouterProvider } from "react-router-dom"
import Home from './pages/Home/Home';
import Login from './pages/Login/Login';
import { useContext } from 'react';
import { AuthContext } from './context/AuthContext';
import Alumnos from './pages/Alumnos/Alumnos';
import PerfilAlumno from './pages/Alumnos/PerfilAlumno';
import Header from './components/Header'
import Profesores from './pages/Profesores/Profesores';
import Cursos from './pages/Cursos/Cursos';
import PerfilProfesor from './pages/Profesores/PerfilProfesor'
import Curso from './pages/Cursos/Curso';
import FormCurso from './components/FormCurso';
import CursosAlumno from './pages/Alumnos/CursosAlumno';
import CursosProfesor from './pages/Profesores/CursosProfesor';
import Admin from './pages/Admin/Admin';
import FormEditAlumno from './components/FormEditAlumno';


function ProtectedRoute({ children }) {
  const {data} = useContext(AuthContext)
  if (!data.user) {
    return <Navigate to={"/login"} />
  }
  return children
}

function Layout() {
  return (
    <div>
      <Header />
      <Outlet />
    </div>
  )
}


const router = createBrowserRouter([
  {
    path: "/",
    element: <ProtectedRoute><Layout /></ProtectedRoute>,
    children: [
      {
        path: "/",
        element: <Home />
      },
      {
        path: "/alumno/:id",
        element: <PerfilAlumno/>
      },
      {
        path:"/alumno",
        element: <Alumnos />
      },
      {
        path:"/alumno/update/:id",
        element: <FormEditAlumno/>
      },
      {
        path:"/alumno/add-cursos/:id",
        element: <CursosAlumno />
      },
      {
        path:"/profesor/:id",
        element: <PerfilProfesor />
      },
      {
        path:"/profesor",
        element: <Profesores />
      },
      {
        path:"/profesor/add-cursos/:id",
        element: <CursosProfesor />
      },
      {
        path:"/curso/:id",
        element: <Curso/>
      },
      {
        path:"/curso",
        element: <Cursos />
      },
      {
        path:"/curso/crear",
        element: <FormCurso />
      },
      {
        path:"/admin",
        element:<Admin/>
      }
    ]
  },
  {
    path: "/login",
    element:<Login />
  },
  {
    path: "/register",
    element: <Register />
  }
]);

function App() {

  return (
    <div className="App">
      
      <RouterProvider router={router} />
    </div>
  );
}

export default App;
