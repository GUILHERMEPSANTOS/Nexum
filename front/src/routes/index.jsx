import React from "react";
import Form from "../components/form/form";
import HomePage from "../pages/home/homepage";
import Profile from "../pages/profile/profile";
import { createBrowserRouter } from "react-router-dom";
import Matched from "../components/profile/matched/matched";
import CardMain from "../components/profile/cardTelaInicio/card";
import Propostas from "../components/profile/propostas/propostas";
import InicioMain from "../components/profile/inicio/tela_inicio";
import FreelancerChoose from "../pages/profilePages/freelancersChoose/freelancersChoose";
import FreelancersOptions from "../pages/profilePages/freelancersOptions/freelancersOptions";

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
