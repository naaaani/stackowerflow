import { useState } from "react";
import { useNavigate } from "react-router-dom";
import QuestionForm from "./QuestionForm";


const createQuestion = async question => {
  const res = await fetch("/api/questions/", {
    method: "POST",
    headers: {
      "Content-Type": "application/json"
    },
    body: JSON.stringify(question)
  });
  console.log(question);
  return await res.json();
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
    <QuestionForm
      onCancel={() => navigate("/")}
      disabled={loading}
      onSave={handleCreatequestion}
    />
  );
};

export default QuestionCreator;
