



function Answer(props){
  return (
    <>
    <div>Answer: {props.answer.body}</div>
    <h2>created at: {props.answer.created_at}</h2>
    <h2>likes: {props.answer.like_count}</h2>
    <button onClick={()=>{props.onLikeClick(props.answer.id)}}>Like this answer</button>
    </>
  )

}


export default Answer;