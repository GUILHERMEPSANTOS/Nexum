import React from "react";
import { createBrowserRouter } from "react-router-dom";
import Form from "../components/Form/Form";
import HomePage from "../pages/homepage";

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
]);
