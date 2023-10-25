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

      <div className="control">
        <label htmlFor="title">Question title:</label>
        <input
          defaultValue={Question ? Question.title : null}
          name="title"
          id="title"
        />
      </div>

      <div className="control">
        <label htmlFor="details">Details:</label>
        <input
          defaultValue={Question ? Question.details : null}
          name="details"
          id="details"
        />
      </div>

      <div className="control">
        <label htmlFor="position">Position:</label>
        <input
          defaultValue={Question ? Question.position : null}
          name="position"
          id="position"
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
