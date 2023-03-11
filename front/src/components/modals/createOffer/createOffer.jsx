import Text from "../../text/text";
import Button from "../../buttons/button";
import Modal from "../modal";
import styles from "./styles.module.scss";
import { useState } from "react";

const CreateOffer = ({ actualState, setActualState }) => {
  const [designer, setDesigner] = useState(false);
  const [programador, setProgramador] = useState(false);
  const [marketing, setMarketing] = useState(false);
  const [illustrator, setIllustrator] = useState(false);
  const [premier, setPremier] = useState(false);
  const [photoshop, setPhotoshop] = useState(false);
  const [inkscape, setInkscape] = useState(false);
  const [figma, setFigma] = useState(false);
  const [java, setJava] = useState(false);
  const [react, setReact] = useState(false);
  const [c, setc] = useState(false);
  const [csharp, setCsharp] = useState(false);
  const [javascript, setJavaScript] = useState(false);
  const [projeto, setProjeto] = useState();
  const [page, setPage] = useState(1);

  return (
    <Modal
      offers={true}
      text={"Crie a sua vaga"}
      label={
        page == 1
          ? "Qual serviço você está procurando?"
          : page == 2
          ? "Quais habilidades está procurando?"
          : "Descreva o projeto que está buscando"
      }
      actualState={actualState}
      setActualState={setActualState}
    >
      <div className={styles.container}>
        {page == 1 && (
          <>
            <div className={styles.containerLabel}>
              <Text isSmall={true} text="Designer" />
              <label className={styles.switch}>
                <input
                  onChange={({ target }) => setDesigner(target.checked)}
                  value={designer}
                  type="checkbox"
                />
                <span className={styles.slider}></span>
              </label>
            </div>
            <div className={styles.containerLabel}>
              <Text isSmall={true} text="Programador" />
              <label className={styles.switch}>
                <input
                  onChange={({ target }) => setProgramador(target.checked)}
                  value={programador}
                  type="checkbox"
                />
                <span className={styles.slider}></span>
              </label>
            </div>
            <div className={styles.containerLabel}>
              <Text isSmall={true} text="Marketing" />
              <label className={styles.switch}>
                <input
                  onChange={({ target }) => setMarketing(target.checked)}
                  value={marketing}
                  type="checkbox"
                />
                <span className={styles.slider}></span>
              </label>
            </div>
          </>
        )}
        {page == 2 && (
          <div className={styles.choisesContainer}>
            {designer && !marketing && (
              <>
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
              </>
            )}
            {marketing && !designer && (
              <>
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
              </>
            )}
            {programador && (
              <>
                <div className={styles.containerLabel}>
                  <Text isSmall={true} text="Java" />
                  <label className={styles.switch}>
                    <input
                      onChange={({ target }) => setJava(target.checked)}
                      value={java}
                      type="checkbox"
                    />
                    <span className={styles.slider}></span>
                  </label>
                </div>
                <div className={styles.containerLabel}>
                  <Text isSmall={true} text="C++" />
                  <label className={styles.switch}>
                    <input
                      onChange={({ target }) => setc(target.checked)}
                      value={c}
                      type="checkbox"
                    />
                    <span className={styles.slider}></span>
                  </label>
                </div>
                <div className={styles.containerLabel}>
                  <Text isSmall={true} text="C#" />
                  <label className={styles.switch}>
                    <input
                      onChange={({ target }) => setCsharp(target.checked)}
                      value={csharp}
                      type="checkbox"
                    />
                    <span className={styles.slider}></span>
                  </label>
                </div>
                <div className={styles.containerLabel}>
                  <Text isSmall={true} text="JavaScript" />
                  <label className={styles.switch}>
                    <input
                      onChange={({ target }) => setJavaScript(target.checked)}
                      value={javascript}
                      type="checkbox"
                    />
                    <span className={styles.slider}></span>
                  </label>
                </div>
                <div className={styles.containerLabel}>
                  <Text isSmall={true} text="React" />
                  <label className={styles.switch}>
                    <input
                      onChange={({ target }) => setReact(target.checked)}
                      value={react}
                      type="checkbox"
                    />
                    <span className={styles.slider}></span>
                  </label>
                </div>
              </>
            )}
          </div>
        )}
        {page == 3 && (
          <>
            <textarea
              onChange={({ target }) => setProjeto(target.value)}
              value={projeto}
              className={styles.textArea}
            />
          </>
        )}
      </div>
      <div className={styles.buttons}>
        {page == 2 && (
          <img
            className={styles.back}
            onClick={() => setPage(page - 1)}
            src="../../assets/icons/back.svg"
          />
        )}
        {page == 3 ? (
          <div className={styles.buttons}>
            <img
              className={styles.back}
              onClick={() => setPage(page - 1)}
              src="../../assets/icons/back.svg"
            />
            <Button
              onClick={() => setActualState(false)}
              isEmpty={true}
              text="Salvar"
            />
          </div>
        ) : (
          <img
            onClick={() => {
              if (designer || programador || marketing) {
                setPage(page + 1);
              } else {
                window.alert("Por favor, selecione uma opção");
              }
            }}
            className={styles.icon}
            src="../../assets/icons/back.svg"
          />
        )}
      </div>
    </Modal>
  );
};

export default CreateOffer;
