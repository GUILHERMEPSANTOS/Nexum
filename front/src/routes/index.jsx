import React from "react";
import Form from "../components/Form/Form";
import HomePage from "../pages/Home/homepage";
import Profile from "../pages/Profile/Profile";
import { createBrowserRouter } from "react-router-dom";
import Matched from "../components/Profile/Matched/Matched";
import CardMain from "../components/Profile/CardTelaInicio/card";
import Propostas from "../components/Profile/Propostas/propostas";
import InicioMain from "../components/Profile/Inicio/tela_inicio";
import FreelancerChoose from "../pages/ProfilePages/FreelancersChoose/FreelancersChoose";
import FreelancersOptions from "../pages/ProfilePages/FreelancersOptions/FreelancersOptions";

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
  {
    path: "/favoritos",
    element: <FreelancersOptions />,
  },
  {
    path: "/escolha-freelancer",
    element: <FreelancerChoose />,
  },
  {
    path: "/propostas",
    element: <Propostas />,
  },
  {
    path: "/match",
    element: <Matched />,
  },
]);
