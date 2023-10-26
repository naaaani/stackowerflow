import { useState, useEffect } from "react";
import { Link } from "react-router-dom";


async function fetchQuestions() {
  const res = await fetch("/api/questions/all");
  const questions = await res.json();
  console.log(questions)
  return questions;
}

function App() {
  const [questions, SetQuestions] = useState(null);

  useEffect(() => {
    async function task() {
      const questions = await fetchQuestions();
      SetQuestions(questions);
    }
    task();
  }, []);
  if (!questions) {
    return (
      <>
        <div>Loading</div>
      </>
    );
  }

  return (
    <>
      {questions.map(question => {
        return (
          <div key={question.id}>
            <h2>Title: {question.title}</h2>
            <h2>Number of answers: {question.answerCount}</h2>
            <h2>Date added: {question.created}</h2>
            <h2>Likes: {question.likes}</h2>
            <Link to={`/question/${question.id}`}>
              <button>Show details</button>
            </Link>
          </div>
        );
      })}
      ;
    </>

  );
}

export default App;
