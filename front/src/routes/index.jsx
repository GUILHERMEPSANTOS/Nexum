import React from "react";
import { createBrowserRouter } from "react-router-dom";
import FreelancerChoose from "../pages/ProfilePages/FreelancersChoose/FreelancersChoose";
import Form from "../components/Form/Form";
import HomePage from "../pages/Home/homepage";
import Profile from "../pages/Profile/profile";
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
    path: "/favoritos",
    element: <FreelancersOptions />,
  },
  {
    path: "/escolha-freelancer",
    element: <FreelancerChoose />,
  },
]);
