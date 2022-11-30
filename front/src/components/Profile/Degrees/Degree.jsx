import { useMemo, useState, useCallback } from "react";
import Text from "../../Text/Text";
import Title from "../../Title/Title";
import Button from "../../Buttons/Button";
import styles from "./styles.module.scss";
import EditDegrees from "../../Modals/EditDegrees/EditDegrees";
import { listCertificadoByFreelancerId } from "../../../services/Freelancer/certificacao";
import { useQuery } from "@tanstack/react-query";
import { getDownload } from "../../../services/Importacao/freelancer";

const Degrees = ({ canEdit = true }) => {
  const upload = localStorage.getItem("upload");
  const userId = useMemo(() => localStorage.getItem("user_id"));
  const [idCertificado, setIdCertificado] = useState();

  const [editDegrees, setEditDegrees] = useState(false);
  const [add, setAdd] = useState(false);
  const [edit, setEdit] = useState(false);

  const { data, isLoading, refetch } = useQuery(
    ["consultar certificados"],
    async () => await listCertificadoByFreelancerId(userId)
  );
  const handleUpload = useCallback(async () => {
    await getDownload({ file: upload });
  }, [upload]);

  if (isLoading) {
    return <div>Loding...</div>;
  }

  return (
    <>
      <section className={styles.container}>
        <Title text="Certificações" />
        {canEdit && (
          <div className={styles.add}>
            <img
              onClick={() => {
                setAdd(true);
                setEdit(false);
                setEditDegrees(true);
              }}
              className={styles.editIcon}
              src="../../assets/icons/add.svg"
            />
          </div>
        )}
        {data?.data.map(
          ({ curso, instituicao, cidade, estado, id_certificacao }, i) => (
            <div key={`${curso} - ${i}`}>
              {canEdit && (
                <div className={styles.edit}>
                  <img
                    onClick={() => {
                      setEdit(true);
                      setAdd(false);
                      setEditDegrees(true);
                      setIdCertificado(id_certificacao);
                    }}
                    className={styles.editIcon}
                    src="../../assets/icons/edit.svg"
                  />
                </div>
              )}

              <div className={styles.wrapper}>
                <img src={`../../assets/imgs/${instituicao}.png`} />
                <div className={styles.contentContainer}>
                  <div>
                    <Text text={curso} />
                    <Text text={instituicao} isSmall={true} />
                  </div>
                  <Button onClick={handleUpload} text="Ver credenciais" />
                </div>
              </div>
              <Text text={cidade} isSmall={true} />
              <Text text={estado} isSmall={true} />
            </div>
          )
        )}
      </section>
      {editDegrees && (
        <EditDegrees
          idCertificado={idCertificado}
          edit={edit}
          add={add}
          refetch={refetch}
          actualState={editDegrees}
          setActualState={setEditDegrees}
        />
      )}
    </>
  );
};

export default Degrees;
