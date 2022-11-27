import Company from "../../../pages/Profile/Company/Company";

const Matched = () => {
  return (
    <>
      {list.map(() => (
        <Company isFreela={true} />
      ))}
    </>
  );
};

export default Matched;
