import React from "react";
import { createBrowserRouter } from "react-router-dom";
import Profile from "../pages/Profile/Profile";
import FreelancerChoose from "../pages/ProfilePages/FreelancersChoose/FreelancersChoose";
import Form from "../components/Form/Form";
import HomePage from "../pages/Home/homepage";
import InicioMain from "../components/Profile/Inicio/tela_inicio";
import CardMain from "../components/Profile/CardTelaInicio/card";
import FreelancersOptions from "../pages/ProfilePages/FreelancersOptions/FreelancersOptions";
import Propostas from "../components/Profile/Propostas/propostas";

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
]);
