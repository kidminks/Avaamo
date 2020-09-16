import React, {useEffect, useState} from "react";
import {BASE_URL, TOPICS_URL} from "../utils/fetch";
import {Empty, notification} from "antd";
import styled from 'styled-components';
import ArrowBackIosIcon from '@material-ui/icons/ArrowBackIos';
import ThumbUpOutlinedIcon from '@material-ui/icons/ThumbUpOutlined';
import {Button, TextareaAutosize, CardContent, Card} from '@material-ui/core';
import Login from "./Login";

const Header = styled.div`
    border: 1px solid rgb(235, 237, 240);
    padding: 1em;
`;

const Row = styled.div`
    flex: 1;
    display: flex;
    justify-content: space-between
`;

export const TopicPage = props => {
    const [topic, setTopic] = useState(undefined);
    const [comments, setComments] = useState(undefined);
    const [comment, setComment] = useState(undefined);
    const [creatorId] = useState(localStorage.getItem('id'));
    const [userName] = useState(localStorage.getItem('user_name'));
    const [openLoginModal, setOpenLoginModal] = useState(false);

    const submitComment = () => {
        fetch(`${BASE_URL}${TOPICS_URL}`, {
            method: 'post',
            body: JSON.stringify({
                content: comment,
                type: 'COMMENTS',
                creator_id: creatorId,
                topic_id_for_comment: props.match.params.id,
                permalink: comment.toLowerCase().replace(' ', '_')
            }),
            headers: new Headers({
                'Content-Type': 'application/json'
            })
        })
            .then(res => {
                window.location.reload(false);
            })
    }

    const increaseLikes = (likes) => {
        fetch(`${BASE_URL}${TOPICS_URL}/${props.match.params.id}`, {
            method: 'post',
            body: JSON.stringify({
                likes: likes
            }),
            headers: new Headers({
                'Content-Type': 'application/json'
            })
        }).then(res => res.json())
            .then(res => setTopic(res))
    }

    useEffect(() => {
        if (topic) {
            setComments(topic.comments);
        }
    }, [topic])

    useEffect(() => {
        fetch(`${BASE_URL}${TOPICS_URL}/${props.match.params.id}`)
            .then(res => res.json())
            .then(res => {
                if (res && res.id) {
                    setTopic(res)
                } else {
                    notification.error({
                        message: "Topic not found",
                        description: "topic not present"
                    })
                }
            })
    }, [])

    return <div style={{fontFamily: 'Open Sans'}}>
        <Header>
            <Row style={{fontSize: '1.5em', marginBottom: '1em'}}>
                <div style={{display: 'flex'}} onClick={() => {
                    props.history.push({
                        pathname: `/topics`
                    })
                }}>
                    <ArrowBackIosIcon/> Avaaro Test
                </div>
                {(userName && userName != "") ? <div>Hi {userName}</div> : <div onClick={() => {
                    setOpenLoginModal(true)
                }}>Log in</div>
                }
            </Row>
        </Header>
        <Row style={{padding: '1em', justifyContent: 'flex-end'}}>
            <Row style={{flex: '0.7', flexDirection: 'column'}}>
                {topic &&
                <Card style={{marginTop: '0.5em'}} variant="outlined">
                    <CardContent>
                        <Row style={{justifyContent: 'flex-end'}}>
                            <Row style={{flexDirection: 'column', flex: '0.9'}}>
                                <h3>{topic.subject}</h3>
                                <p>{topic.content}</p>
                                <p>Created By :- {topic.users.name}</p>
                                <span onClick={() => {
                                    increaseLikes(topic.likes + 1)
                                }}>
                                    {topic.likes} <ThumbUpOutlinedIcon/>
                                </span>
                            </Row>
                        </Row>
                    </CardContent>
                </Card>}
                <Row>
                    <h2>Comments</h2>
                </Row>
                <Row>
                    {creatorId &&
                    <span>
                        <TextareaAutosize placeholder='Enter Comment' rowsMin={3} style={{width: '100%'}}
                                          onChange={(e) => {
                                              setComment(e.target.value);
                                          }}/>
                        <Button variant="contained" disabled={!comment || comment == ''}
                                onClick={() => submitComment()}>Submit</Button>
                    </span>
                    }
                </Row>
                <Row style={{
                    marginTop: '0.5em',
                    justifyContent: 'center',
                    alignItems: 'center',
                    width: '100%',
                    flexDirection: 'column'
                }}>
                    {comments && comments.length > 0 ? comments.map(c =>
                            <Card style={{marginTop: '0.5em', width: '100%'}}
                                  variant="outlined">
                                <CardContent>
                                    <Row style={{justifyContent: 'flex-end'}}>
                                        <Row style={{flexDirection: 'column', flex: '0.9'}}>
                                            <p>{c.content}</p>
                                            <span style={{color: 'grey'}}>
                                                <p>Created By :- {c.users && c.users.name}</p>
                                                <p>Created At :- {c.created_at}</p>
                                            </span>
                                        </Row>
                                    </Row>
                                </CardContent>
                            </Card>) :
                        <Empty/>}
                </Row>
            </Row>
            <Row style={{flex: '0.3', flexDirection: 'column'}}>
            </Row>
        </Row>
        {
            openLoginModal && <Login
                showModal={openLoginModal}
                setShowModal={(data) => {
                    setOpenLoginModal(false);
                }}
            />
        }
    </div>
}