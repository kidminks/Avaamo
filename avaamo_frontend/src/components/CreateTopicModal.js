import React, {useState} from 'react';
import {makeStyles} from '@material-ui/core/styles';
import Modal from '@material-ui/core/Modal';
import {TextField, TextareaAutosize, Button, Select, MenuItem} from '@material-ui/core';
import {BASE_URL, TOPICS_URL} from "../utils/fetch";

const getModalStyle = () => {
    const top = 40;
    const left = 50;

    return {
        top: `${top}%`,
        left: `${left}%`,
        transform: `translate(-${top}%, -${left}%)`,
    };
}

const useStyles = makeStyles((theme) => ({
    paper: {
        position: 'absolute',
        width: 600,
        backgroundColor: theme.palette.background.paper,
        border: '2px solid #000',
        boxShadow: theme.shadows[5],
        padding: theme.spacing(2, 4, 3),
    },
}));

const CreateTopicModal = ({showModal, setShowModal}) => {
    const classes = useStyles();
    const [modalStyle] = React.useState(getModalStyle);
    const [subject, setSubject] = useState("");
    const [content, setContent] = useState("");
    const [type, setType] = useState("DISCUSSION");
    const [creatorId] = useState(localStorage.getItem('id'));

    const submitTopic = () => {
        fetch(`${BASE_URL}${TOPICS_URL}`, {
            method: 'post',
            body: JSON.stringify({
                subject: subject,
                content: content,
                type: type,
                status: 'PUBLISHED',
                creator_id: creatorId,
                permalink: subject.toLowerCase().replace(' ', '_')
            }),
            headers: new Headers({
                'Content-Type': 'application/json'
            })
        })
            .then(res => {
                window.location.reload(false);
            })
    }

    const body = (
        <div style={modalStyle} className={classes.paper}>
            <h2 id="simple-modal-title">Create Topic</h2>
            <div>
                <TextField id="standard-basic" label="Subject" style={{width: '100%', marginBottom: '1em'}}
                           onChange={(e) => {
                               setSubject(e.target.value)
                           }}/>
            </div>
            <div>
                <TextareaAutosize placeholder='Enter Comment' rowsMin={3} style={{width: '100%', marginBottom: '1em'}} onChange={(e) => {
                    setContent(e.target.value)
                }}/>
            </div>
            <Select
                labelId="demo-simple-select-helper-label"
                id="demo-simple-select-helper"
                value={type}
                onChange={(e) => {
                    setType(e.target.value);
                }}
            >
                <MenuItem value="DISCUSSION">Discussion</MenuItem>
                <MenuItem value="IDEA">Idea</MenuItem>
                <MenuItem value="QUESTION">Question</MenuItem>
            </Select>
            <div style={{width: '100%', display: 'flex', justifyContent: 'center', marginTop: '1em'}}>
                <Button variant="contained" disabled={!subject || subject == "" || !content || content == ""}
                        onClick={() => {
                            submitTopic()
                        }}>Submit</Button>
            </div>
        </div>
    );

    return (
        <div>
            <Modal
                open={showModal}
                onClose={() => {
                    setShowModal(false)
                }}
                aria-labelledby="simple-modal-title"
                aria-describedby="simple-modal-description"
            >
                {body}
            </Modal>
        </div>
    );
}

export default CreateTopicModal;
