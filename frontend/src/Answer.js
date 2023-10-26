
async function deleteAnswer(id) {
  const res = await fetch(`/api/answers/${id}`, {
    method: "DELETE",
  });
  return await res.json();
}


function Answer(props){
  return (
    <>
    <div>Answer: {props.answer.body}</div>
    <h2>created at: {props.answer.created_at}</h2>
    <h2>likes: {props.answer.number_of_likes}</h2>
    <button onClick={()=>{props.onLikeClick(props.answer.id)}}>Like this answer</button>
    
 <button onClick={async ()=>{ await deleteAnswer(props.answer.id);
window.location.reload(false);
}}>Delete this answer</button>
    </>
  )

}


export default Answer;