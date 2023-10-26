const QuestionForm = ({ onSave, disabled, Question, onCancel }) => {
  const onSubmit = e => {
    e.preventDefault();
    const formData = new FormData(e.target);
    const entries = [...formData.entries()];

    const Question = entries.reduce((acc, entry) => {
      const [k, v] = entry;
      acc[k] = v;
      return acc;
    }, {});

    return onSave(Question);
  };

  return (
    <form className="QuestionForm" onSubmit={onSubmit}>
      {Question && (
        <input type="hidden" name="_id" defaultValue={Question._id} />
      )}

      <div>
        <label htmlFor="title">Question title:</label>
        <input
          defaultValue={Question ? Question.title : null}
          name="title"
          id="title"
        />
      </div>

      <div>
        <label htmlFor="body">Details:</label>
        <input
          defaultValue={Question ? Question.body : null}
          name="body"
          id="body"
        />
      </div>

      <div className="buttons">
        <button type="submit" disabled={disabled}>
          {Question ? "Update Question" : "Create Question"}
        </button>

        <button type="button" onClick={onCancel}>
          Cancel
        </button>
      </div>
    </form>
  );
};

export default QuestionForm;
