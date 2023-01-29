import '../../styles/private_pilot/StoryPopup.css';

function StoryPopup(props) {
    return (  
        <div className="story-popup-container">
            {props.story}

            <button onClick={() => props.activateStory(false, "")} className="story-popup-exit">x</button>
        </div>
    );
}

export default StoryPopup;