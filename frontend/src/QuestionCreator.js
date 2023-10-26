import { useState } from "react";
import { useNavigate } from "react-router-dom";


const createQuestion = question => {
  return fetch("/api/questions", {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(question)
  }).then(res => res.json());
};

function QuestionCreator(){
  const navigate = useNavigate();
  const [loading, setLoading] = useState(false);

  const handleCreatequestion = question => {
    setLoading(true);

    createQuestion(question).then(() => {
      setLoading(false);
      navigate("/");
    });
  };

  return (
    <questionForm
      onCancel={() => navigate("/")}
      disabled={loading}
      onSave={handleCreatequestion}
    />
  );
};

export default QuestionCreator;
