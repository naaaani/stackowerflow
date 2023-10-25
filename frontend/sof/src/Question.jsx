import { Link } from "react-router-dom";
import { useState, useEffect } from 'react';
import { useNavigate, useParams } from "react-router-dom";
import Answer from './Answer';

async function fetchAnswersForQuestion(id){
  const res = await fetch(`/api/questions-for-answer/${id}`);
  const answers = await res.json();
  return answers;
}

async function fetchQuestion(id){
  const res = await fetch(`/api/questions/${id}`);
  const question = await res.json();
  return question;
}

function Question() {

const [answers, setAnswers] = useState(null);
const [question, setQuestion] = useState(null);
const [loading, setLoading] = useState(true);
const { id } = useParams();

useEffect(()=>{
  async function task(){
    const [answers, question] = await Promise.all(fetchAnswersForQuestion(id), fetchQuestion(id));
    setAnswers(answers);
    setQuestion(question);
    setLoading(false);
  }
  task();
},[id]);


if (loading){
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
      <h2>date added: {question.date_added}</h2>
      <h2>Number of likes: {question.number_of_likes}</h2>
      <button>Like this question</button>
      <button>Dislike this question</button>
      <button>Delete this question</button>
      <Link to={`/`}>
        <button>Back to details</button>
      </Link>
<div>Answers
  {answers.map((answer)=>{return (
    <Answer
    key={answer.id}
    answer={answer}
    />
  )})}
</div>
    </>
  )
}
export default Question;

