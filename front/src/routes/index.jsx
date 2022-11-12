import React from "react";
import { createBrowserRouter } from "react-router-dom";
import Profile from "../pages/profile/profile";
import Form from "../components/Form/Form";
import HomePage from "../pages/Home/homepage";
import InicioMain from "../components/Profile/Inicio/tela_inicio";
import CardMain from "../components/Profile/Card Tela Inicio/card";

export const router = createBrowserRouter([
  {
    path: "/",
    element: <HomePage />,
  },
  {
    path: "/login",
    element: <Form />,
  },
  {
    path: "/cadastro",
    element: <Form />,
  },
  {
    path: "/perfil",
    element: <Profile />,
  },
  {
    path: "/inicio",
    element: <InicioMain />,
  },
  {
    path: "/card",
    element: <CardMain />,
  },

]);
