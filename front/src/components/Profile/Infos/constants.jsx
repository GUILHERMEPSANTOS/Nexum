const date = new Date();
const today = ` 0${date.getDate()}/ ${
  date.getMonth() + 1
}/ ${date.getFullYear()}`;

export const INFOS = [
  {
    text: "Projetos:",
    number: "",
  },
  {
    text: "Avaliações:",
    number: "",
    rate: "",
  },
  {
    text: "Desde:",
    date: today,
  },
];

export const HABILITIES = [
  {
    icon: "figma",
    text: "Figma",
  },
  {
    icon: "illustrator",
    text: "Illustrator",
  },
  {
    icon: "premier",
    text: "Premier",
  },
  {
    icon: "photoshop",
    text: "Photoshop",
  },
  {
    icon: "inkscape",
    text: "Inkscape",
  },
];

export const ACHIEVEMENT = [
  {
    text: "Realizou determinada coisa",
    icon: "conquista1",
    name: "Conquista",
  },
  {
    text: "Realizou determinada coisa",
    icon: "conquista2",
    name: "Conquista",
  },
  {
    text: "Realizou determinada coisa",
    icon: "conquista3",
    name: "Conquista",
  },
  {
    text: "Realizou determinada coisa",
    icon: "conquista4",
    name: "Conquista",
  },
  {
    text: "Realizou determinada coisa",
    icon: "conquista5",
    name: "Conquista",
  },
  {
    text: "Realizou determinada coisa",
    icon: "conquista6",
    name: "Conquista",
  },
];
