import React from "react";
import { createBrowserRouter } from "react-router-dom";
import FreelancerChoose from "../pages/ProfilePages/FreelancersChoose/FreelancersChoose";
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
<<<<<<< HEAD
    path: "/inicio",
    element: <InicioMain />,
  },
  {
    path: "/card",
    element: <CardMain />,
  },

=======
    path: "/favoritos",
    element: <FreelancersOptions />,
  },
  {
    path: "/escolha-freelancer",
    element: <FreelancerChoose />,
  },
>>>>>>> 20d13f5ded4be227a30c65efdf564008410374aa
]);
