import { Grid} from "@mui/material";
import { useAppSelector} from "../../store";
import SideBarProfile from "../molecules/SideBarProfile";
import SideBarAddEmployee from "../molecules/ManagerComponents/SideBarAddEmployee";
import SideBarEmployees from "../molecules/ManagerComponents/SideBarEmployees";
import SideBarHolidayTableUser from "../molecules/ManagerComponents/SideBarHolidayTableUser";
import SideBarNotifications from "../molecules/AdminPageComponents/SideBarNotifications";
import SideBarCompany from "../molecules/ManagerComponents/SideBarCompany";
export const ManagerMenuContentRenderer = () => {
    const page = useAppSelector((state) => state.auth.pageState);

    return (
        <>
            <Grid item xs={12}>
                {page === 'Holidays' && <SideBarHolidayTableUser />}
                {page === 'Profile' && <SideBarProfile/>}
                {page === 'Add Employee' && <SideBarAddEmployee/>}
                {page === 'Employees' && <SideBarEmployees/>}
                {page === 'Notifications' && <SideBarNotifications/>}
                {page === 'Company' && <SideBarCompany/>}
            </Grid>
        </>
    );
};

