import { useCallback } from "react";

import { useQuery, useMutation } from "@tanstack/react-query";

import Text from "../../text/text";
import Button from "../../buttons/button";
import Modal from "../modal";
import styles from "./styles.module.scss";
import { useState } from "react";
import {
  listHabilidades,
  postHabilidades,
} from "../../../services/freelancer/habilidades";

const EditInfo = ({ actualState, setActualState }) => {
  const [illustrator, setIllustrator] = useState(false);
  const [premier, setPremier] = useState(false);
  const [photoshop, setPhotoshop] = useState(false);
  const [inkscape, setInkscape] = useState(false);
  const [figma, setFigma] = useState(false);

  const [habilidades, setHabilidades] = useState([]);

  const { data } = useQuery(
    ["consultar habilidades"],
    () => listHabilidades(),
    {
      onSuccess: (data) => {
        setHabilidades(
          data?.data?.map(({ id_habilidade }) => ({
            id_habilidade,
          }))
        );
      },
    }
  );

  const { mutate } = useMutation(
    ({ data, userId }) => postHabilidades(data, userId),
    {
      onSuccess: () => {
        refetch();
      },
    }
  );

  const handleChangeCurrentValueOption = useCallback(
    (data) => {
      const updateHabilidades = habilidades.map((habilidades) => {
        if (habilidades.id_habilidade === data.id_habilidade) {
          return { ...habilidades, ...data };
        }

        return habilidades;
      });

      setHabilidades(updateHabilidades);
    },
    [setHabilidades, habilidades]
  );

  const handleUpdateHabilidades = useCallback(() => {
    mutate({ data: habilidades, userId });
    setActualState(false);
  }, [habilidades]);

  return (
    <Modal
      text={"Habilidades"}
      label={"Quais habilidades você possui?"}
      actualState={actualState}
      setActualState={setActualState}
    >
      <div className={styles.container}>
        <div className={styles.containerLabel}>
          <Text isSmall={true} text="Illustrator" />
          <label className={styles.switch}>
            <input
              onChange={({ target }) => setIllustrator(target.checked)}
              value={illustrator}
              type="checkbox"
            />
            <span className={styles.slider}></span>
          </label>
        </div>
        <div className={styles.containerLabel}>
          <Text isSmall={true} text="Premier" />
          <label className={styles.switch}>
            <input
              onChange={({ target }) => setPremier(target.checked)}
              value={premier}
              type="checkbox"
            />
            <span className={styles.slider}></span>
          </label>
        </div>
        <div className={styles.containerLabel}>
          <Text isSmall={true} text="Photoshop" />
          <label className={styles.switch}>
            <input
              onChange={({ target }) => setPhotoshop(target.checked)}
              value={photoshop}
              type="checkbox"
            />
            <span className={styles.slider}></span>
          </label>
        </div>
        <div className={styles.containerLabel}>
          <Text isSmall={true} text="Inkscape" />
          <label className={styles.switch}>
            <input
              onChange={({ target }) => setInkscape(target.checked)}
              value={inkscape}
              type="checkbox"
            />
            <span className={styles.slider}></span>
          </label>
        </div>
        <div className={styles.containerLabel}>
          <Text isSmall={true} text="Figma" />
          <label className={styles.switch}>
            <input
              onChange={({ target }) => setFigma(target.checked)}
              value={figma}
              type="checkbox"
            />
            <span className={styles.slider}></span>
          </label>
        </div>
      </div>
      <div className={styles.buttons}>
        <Button
          onClick={handleUpdateHabilidades}
          isEmpty={true}
          text="Salvar"
        />
      </div>
    </Modal>
  );
};

export default EditInfo;
