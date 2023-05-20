const closeSession = (navigate) => {
  localStorage.removeItem("userData");
  navigate("/");
};

export default closeSession;
