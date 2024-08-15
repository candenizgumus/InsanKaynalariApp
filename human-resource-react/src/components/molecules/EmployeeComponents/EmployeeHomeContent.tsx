import React, { useEffect, useState } from 'react';
import MyCalendar, { IShift } from "../../atoms/MyCalender";
import { useDispatch } from "react-redux";
import { HumanResources, useAppSelector } from "../../../store";
import { fetchFindShiftsOfEmployee, fetchSaveShift, fetchUpdateShift, fetchDeleteShift } from "../../../store/feature/shiftSlice";

export const EmployeeHomeContent: React.FC = () => {
    const [events, setEvents] = useState<IShift[]>([]);
    const dispatch = useDispatch<HumanResources>();
    const token = useAppSelector((state) => state.auth.token);

    const getShiftsOfEmployee = () => {
        dispatch(fetchFindShiftsOfEmployee({ employeeId: 7, token: token })).then(data => {
            setEvents(data.payload);
        });
    };

    useEffect(() => {
        getShiftsOfEmployee();
    }, []);

    const handleSaveEvent = (newEvent: IShift) => {
        dispatch(fetchSaveShift({
            token: token,
            companyId: newEvent.companyId,
            employeeId: newEvent.employeeId,
            description: newEvent.description,
            start: newEvent.start,
            endTime: newEvent.endTime,
            title: newEvent.title,
        })).then((response) => {
            setEvents(prevEvents => [...prevEvents, { ...newEvent, id: response.payload.id }]);
        }).catch((error) => {
            console.error('Failed to save the event:', error);
        });
    };

    const handleUpdateEvent = (updatedEvent: IShift) => {
        if (updatedEvent.id) {
            dispatch(fetchUpdateShift({
                token: token,
                shiftId: updatedEvent.id,
                description: updatedEvent.description,
                start: updatedEvent.start,
                endTime: updatedEvent.endTime,
                title: updatedEvent.title,
            })).then(() => {
                setEvents(prevEvents => {
                    const existingEventIndex = prevEvents.findIndex(e => e.id === updatedEvent.id);
                    if (existingEventIndex !== -1) {
                        const newEvents = [...prevEvents];
                        newEvents[existingEventIndex] = updatedEvent;
                        return newEvents;
                    }
                    return prevEvents;
                });
            }).catch((error) => {
                console.error('Failed to update the event:', error);
            });
        }
    };

    const handleDeleteEvent = (eventId: number) => {
        dispatch(fetchDeleteShift({
            token: token,
            shiftId: eventId,
        })).then(() => {
            setEvents(prevEvents => prevEvents.filter(event => event.id !== eventId));
        }).catch((error) => {
            console.error('Failed to delete the event:', error);
        });
    };

    return <MyCalendar events={events} isUserManager={false}  />;
};
