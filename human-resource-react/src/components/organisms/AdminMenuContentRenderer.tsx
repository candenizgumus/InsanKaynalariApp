import { Grid} from "@mui/material";
import { useAppSelector} from "../../store";
import SideBarOffers from "../molecules/AdminPageComponents/SideBarOffers";
import SideBarHolidayTable from "../molecules/SideBarHolidayTable";
import SideBarCreateAdmin  from "../molecules/AdminPageComponents/SideBarCreateAdmin";
import SideBarCreateFeature  from "../molecules/AdminPageComponents/SideBarCreateFeature";
import SideBarProfile from "../molecules/SideBarProfile";
import SideBarUsers from "../molecules/AdminPageComponents/SideBarUsers";
import CompanyList from "../molecules/AdminPageComponents/SideBarCompanies";
import SideBarAddEmployee from "../molecules/ManagerComponents/SideBarAddEmployee";
import SideBarEmployees from "../molecules/ManagerComponents/SideBarEmployees";
import {SideBarEmployeeShiftsAndBreaks} from "../molecules/EmployeeComponents/SideBarEmployeeShiftsAndBreaks";
import {SideBarEmployeeLeaves} from "../molecules/EmployeeComponents/SideBarEmployeeLeaves";
import {SideBarEmployeeCompanyItems} from "../molecules/EmployeeComponents/SideBarEmployeeCompanyItems";
import {lazy} from "react";
import ChangePassword from "../molecules/ChangePassword";
import SideBarCompany from "../molecules/ManagerComponents/SideBarCompany";
const EditEmployee = lazy(() => import('../molecules/ManagerComponents/EditEmployee'));
const SideBarCreateComment = lazy(() => import('../molecules/ManagerComponents/SideBarCreateComment'));
export const AdminMenuContentRenderer = () => {
    const page = useAppSelector((state) => state.auth.pageState);

    return (
        <>
            <Grid item xs={12}>
                {page === 'Offers' && <SideBarOffers />}
                {page === 'Create Admin' && <SideBarCreateAdmin />}
                {page === 'Create Feature' && <SideBarCreateFeature />}
                {page === 'Holidays' && <SideBarHolidayTable />}
                {page === 'Profile' && <SideBarProfile/>}
                {page === 'Companies' && <CompanyList/>}
                {page === 'Users' && <SideBarUsers/>}
                {page === 'Add Employee' && <SideBarAddEmployee/>}
                {page === 'Employees' && <SideBarEmployees/>}
                {page === 'Shifts & Breaks' && <SideBarEmployeeShiftsAndBreaks />}
                {page === 'Leaves' && <SideBarEmployeeLeaves/>}
                {page === 'Company Items' && <SideBarEmployeeCompanyItems/>}
                {page === 'Edit Employee' && <EditEmployee/>}
                {page === 'Change Password' && <ChangePassword/>}
                {page === 'Add Comment' && <SideBarCreateComment/>}
                {page === 'Edit Company' && <SideBarCompany/>}
            </Grid>
        </>
    );
};

