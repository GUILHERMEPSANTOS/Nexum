import { useEffect, useState } from "react";

export const watchWords = ({ text }) => {
  const [words, setWords] = useState([]);

  useEffect(() => {
    const newText = text.split(" ");
    setWords(newText);
  }, []);

  return {
    words,
  };
};

export default watchWords;
