import { useCallback } from "react";

import Text from "../../../Text/Text";

const OptionSocialMedia = ({ id_social, nome, onChageOption }) => {
  const handleOptionValue = useCallback(
    (event) => {
      onChageOption({
        id_social,
        user_url: event.target.value,
      });
    },
    [onChageOption]
  );

  return (
    <>
      <Text isSmall={true} text={nome} />
      <input onChange={handleOptionValue} />
    </>
  );
};

export default OptionSocialMedia;
