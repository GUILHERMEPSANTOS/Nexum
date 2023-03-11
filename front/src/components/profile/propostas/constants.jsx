
  const data = localStorage.getItem("number") ? localStorage.getItem("number") : "";
  const dataFormatted = data.replace(/"/g, "");

  const dataEmail = localStorage.getItem("email") ? localStorage.getItem("email") : "";
  const dataEmailFormatted = dataEmail.replace(/"/g, "");

  console.log(dataFormatted);
  console.log(dataEmailFormatted);
  // link: `https://wa.me/551193856799`,


export const TEXTS_FREELANCER = [
  {
    title: "Clique aqui para conversar por ",
    text: "WhatsApp",
    link: `https://wa.me/55${dataFormatted}`,
  },
  {
    title: "Clique aqui para conversar por",
    text: "E-mail",
    link: `mailto:${dataEmailFormatted}`,
  },
];


export const OPTIONS = [
  {
    name: "Inicio",
    path: "/inicio",
  },
  { name: "Perfil", path: "/perfil" },
  {
    name: "Favoritos",
    path: "/favoritos",
  },
];
