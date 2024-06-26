import { Link, useNavigate } from "react-router-dom";
import { useState, useEffect } from 'react';
import { useParams } from "react-router-dom";
import Answer from './Answer';



async function fetchAnswersForQuestion(id) {
  const res = await fetch(`/api/answers/by-question-id/${id}`);
  const answers = await res.json();
  console.log(answers);
  return answers;
}

async function fetchQuestion(id) {
  const res = await fetch(`/api/questions/${id}`);
  const question = await res.json();
  return question;
}

async function deleteQuestion(id) {
  const res = await fetch(`/api/questions/${id}`, {
    method: "DELETE",
  });
  return await res.json();
}


async function addLikeToAnswer(answerId) {
  const res = await fetch(`/api/answers/${answerId}`, {
    method: "PUT",
  });
  return await res.json();
}
async function addLikeToQuestion(id) {
  const res = await fetch(`/api/questions/${id}`, {
    method: "PUT",
  });
  console.log("im fetching");
  return await res.json();
}

function Question() {

  const [answers, setAnswers] = useState(null);
  const [question, setQuestion] = useState(null);
  const [loading, setLoading] = useState(true);
  const [newAnswer, setNewAnswer] = useState(
    {
      question_id:-1,
      body: "",
    }
  );
  const navigate = useNavigate();
  const { id } = useParams();

  async function postNewAnswer() {
    const res = await fetch('/api/answers/', {
      method: "POST",
      headers: {
        "Content-Type": "application/json",
      },
      body: JSON.stringify(newAnswer),
    });
    console.log(newAnswer);
    return await res.json();
  }

  async function handleLikeClick(answerId) {

    await addLikeToAnswer(answerId);
    const answers = await fetchAnswersForQuestion(id);
    setAnswers(answers);
  }

  useEffect(() => {
    async function task() {
      const [answers, question] = await Promise.all([fetchAnswersForQuestion(id), fetchQuestion(id)]);
      setAnswers(answers);
      setQuestion(question);
      setLoading(false);

    }
    task();
  }, [id]);


  if (loading) {
    return (
      <>
        <div>Loading</div>
      </>
    )
  }

  return (
    <>
      <div>
        {question.title}
      </div>
      <h2>{question.body}</h2>
      <h2>date added: {question.created}</h2>
      <h2>Number of likes: {question.likes}</h2>
      <button
        onClick={async () => {
          await addLikeToQuestion(id);
          const fetchedQuestion = await fetchQuestion(id);
          setQuestion(fetchedQuestion)
        }}
      >Like this question</button>
      <button
        onClick={async () => {
          await deleteQuestion(id);
          navigate("/");
        }
        }
      >Delete this question</button>
      <Link to={`/`}>
        <button>Back to all questions</button>
      </Link>
      <div>Answers
        {(answers.length > 0) ? answers.map((answer) => {
          return (
            <Answer
              key={answer.id}
              onLikeClick={handleLikeClick}
              answer={answer}
            />
          )
        }) :
          <div>No answers yet</div>}
      </div>
      <div>
        <h2>Add new answer</h2>
        <label htmlFor="text"></label>
        <input id="text" type="text" value={newAnswer.body}
          onChange={
            (e) => {
              const updatedAnswer = { ...newAnswer };
              updatedAnswer.question_id= id;
              updatedAnswer.body = e.target.value;
              console.log(e.target.value)
              setNewAnswer(updatedAnswer);
            }
          }></input>
        <button
          onClick={async () => {
            await postNewAnswer();
            const fetchedAnswers = await fetchAnswersForQuestion(id);
            setAnswers(fetchedAnswers);

          }}
        >submit</button>
      </div>
    </>
  )
}
export default Question;

