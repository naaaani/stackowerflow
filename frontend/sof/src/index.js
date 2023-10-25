import React from "react";
import ReactDOM from "react-dom/client";


import App from './App';
import Question from './Question';
import QuestionCreator from "./QuestionCreator";

import { createBrowserRouter, RouterProvider } from "react-router-dom";
import reportWebVitals from "./reportWebVitals";


const router = createBrowserRouter([
  {
    path: "/",
    element: <Layout />,
    errorElement: <ErrorPage />,
    children: [
      {
        path: "/",
        element: <App />,
      },
      {
        path: "/question/:id",
        element: <Question />,
      },
      {
        path: "/create-question",
        element: <QuestionCreator />
      }
    ],
  }
]);

const root = ReactDOM.createRoot(document.getElementById("root"));
root.render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>
);

reportWebVitals();
