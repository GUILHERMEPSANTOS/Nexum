import React from "react";
import { createBrowserRouter } from "react-router-dom";
import Profile from "../pages/Profile/Profile";
import Form from "../components/Form/Form";
import HomePage from "../pages/Home/homepage";

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
    path: "/profile",
    element: <Profile />,
  },
]);
