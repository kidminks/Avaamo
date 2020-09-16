import React, {useEffect, useState} from "react";
import Complete from "./AutoComplete";
import styled from 'styled-components';
import Pagination from '@material-ui/lab/Pagination';
import Card from '@material-ui/core/Card';
import CardContent from '@material-ui/core/CardContent';
import {BASE_URL, TOPICS_URL} from "../utils/fetch";
import ThumbUpIcon from '@material-ui/icons/ThumbUp';
import ThumbUpOutlinedIcon from '@material-ui/icons/ThumbUpOutlined';
import ArrowForwardIosOutlinedIcon from '@material-ui/icons/ArrowForwardIosOutlined';
import {Button} from '@material-ui/core';
import CreateTopicModal from "./CreateTopicModal";
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

export const TopicsPage = props => {
    const [page, setPage] = useState(0);
    const [totalCount, setTotalCount] = useState(0);
    const [content, setContent] = useState([]);
    const [subject, setSubject] = useState(undefined);
    const [openCreateTopicModal, setOpenCreateTopicModal] = useState(false);
    const [userName] = useState(localStorage.getItem('user_name'));
    const [openLoginModal, setOpenLoginModal] = useState(false);
    const [creatorId] = useState(localStorage.getItem('id'));

    useEffect(() => {
        if (page != undefined) {
            fetch(`${BASE_URL}${TOPICS_URL}?page=${page}&size=5${subject ? `&subject=${subject}` : ''}`)
                .then(res => res.json())
                .then(res => {
                    setTotalCount(res.totalPages);
                    setContent(res.content);
                })
        }
    }, [page, subject])

    return <div style={{fontFamily: 'Open Sans'}}>
        <Header>
            <Row style={{fontSize: '1.5em', marginBottom: '1em'}}>
                <div>Avaaro Test</div>
                {(userName && userName != "") ? <div>Hi {userName}</div> : <div onClick={() => {
                    setOpenLoginModal(true)
                }}>Log in</div>
                }
            </Row>
            <div>
                <Complete onChange={(data) => {
                    if (data && data.length > 0) {
                        setSubject(data[1]);
                    } else {
                        setSubject(undefined);
                    }
                    setPage(0);
                }}/>
            </div>
        </Header>

        <Row style={{padding: '1em', justifyContent: 'flex-end'}}>
            {creatorId && <Button variant="contained" style={{marginRight: '1em'}} onClick={() => {
                setOpenCreateTopicModal(true);
            }}>Create Topic</Button>}
            <Pagination
                page={page + 1}
                count={totalCount}
                variant="outlined" shape="rounded"
                onChange={(e, v) => {
                    setPage(v - 1)
                }}
            />
        </Row>

        <Row style={{flexDirection: 'column', padding: '1em'}}>
            {content && content.length > 0 && content.map(data =>
                <Card style={{marginTop: '0.5em'}} variant="outlined">
                    <CardContent>
                        <Row style={{justifyContent: 'flex-end'}}>
                            <Row style={{flexDirection: 'column', flex: '0.9'}}>
                                <h3>{data.subject}</h3>
                                <p>{data.content}</p>
                                <span style={{color: 'grey'}}>
                                    <p>Created By :- {data.users && data.users.name}</p>
                                    <p>Created At :- {data.created_at}</p>
                                </span>
                            </Row>
                            <Row style={{flex: '0.1', alignItems: 'center', justifyContent: 'center'}} onClick={() => {
                                props.history.push({
                                    pathname: `/topics/${data.id}`
                                })
                            }}>
                                <ArrowForwardIosOutlinedIcon/>
                            </Row>
                        </Row>
                    </CardContent>
                </Card>
            )}
        </Row>
        {
            openCreateTopicModal && <CreateTopicModal
                showModal={openCreateTopicModal}
                setShowModal={(data) => {
                    setOpenCreateTopicModal(false);
                }}
            />
        }
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