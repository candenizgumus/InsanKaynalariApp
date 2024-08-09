package com.humanresourcesapp.utility;

import com.humanresourcesapp.constants.ENotificationTextBase;
import com.humanresourcesapp.dto.requests.NotificationSaveRequestDto;
import com.humanresourcesapp.dto.requests.OfferSaveRequestDto;
import com.humanresourcesapp.entities.*;
import com.humanresourcesapp.entities.enums.*;
import com.humanresourcesapp.services.*;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static com.humanresourcesapp.constants.FrontendPaths.HOME;


@RequiredArgsConstructor
@Service
public class InsertDemoData {
    private final CompanyService companyService;
    private final FeatureService featureService;
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final AuthService authService;
    private final CommentService commentService;
    private final HolidayService holidayService;
    private final OfferService offerService;
    private final NotificationService notificationService;

    @PostConstruct
    public void insert() {
        insertCompanyDemoData();
        insertFeatureDemoData();
        insertCommentDemoData();
        insertHolidayDemoData();
        instertOfferDemoData();

        notificationService.save(NotificationSaveRequestDto.builder()
                .notificationText(ENotificationTextBase.ERROR_NOTIFICATION.getText() + "We have Errors !")
                .userType(EUserType.ADMIN)
                .userId(0L)
                .isRead(false)
                .status(EStatus.ACTIVE)
                .notificationType(ENotificationType.ERROR)
                .url(HOME)
                .build());
    }

    // Company demo data insertion
    private void insertCompanyDemoData() {
        if(companyService.getAll().isEmpty()) {
            List<Company> companyList = new ArrayList<>();
            companyList.add(Company.builder()
                    .name("Airbnb")
                    .logo("https://asset.brandfetch.io/idkuvXnjOH/idxMw0tmPe.png")
                    .numberOfEmployee(1)
                    .status(EStatus.ACTIVE)
                    .country("USA")
                    .build());

            companyList.add(Company.builder()
                    .name("Nike")
                    .logo("https://asset.brandfetch.io/id_0dwKPKT/id_GjBr_LQ.png")
                    .numberOfEmployee(1)
                    .status(EStatus.ACTIVE)
                    .country("USA")
                    .build());

            companyList.add(Company.builder()
                    .name("Puma")
                    .logo("https://asset.brandfetch.io/idDV9AjI6R/idt8Kf_9bU.svg")
                    .numberOfEmployee(1)
                    .status(EStatus.ACTIVE)
                    .country("Germany")
                    .build());

            companyList.add(Company.builder()
                    .name("McDonald's")
                    .logo("https://asset.brandfetch.io/id7ETzoB9W/idqHifpuke.png")
                    .numberOfEmployee(1)
                    .status(EStatus.ACTIVE)
                    .country("USA")
                    .build());

            companyList.add(Company.builder()
                    .name("HSBC")
                    .logo("https://asset.brandfetch.io/idLLTco_Zw/idpShkJ2yo.svg")
                    .numberOfEmployee(1)
                    .status(EStatus.ACTIVE)
                    .country("UK")
                    .build());

            companyList.add(Company.builder()
                    .name("Tesla")
                    .logo("https://asset.brandfetch.io/id2S-kXbuK/idL-smlY7j.png")
                    .numberOfEmployee(1)
                    .status(EStatus.ACTIVE)
                    .country("USA")
                    .build());

            companyList.add(Company.builder()
                    .name("Spotify")
                    .logo("https://asset.brandfetch.io/id20mQyGeY/idZi0Z5Y9U.png")
                    .numberOfEmployee(1)
                    .status(EStatus.ACTIVE)
                    .country("Sweden")
                    .build());

            companyList.add(Company.builder()
                    .name("Apple")
                    .logo("https://asset.brandfetch.io/idnrCPuv87/idzou3XgJV.png")
                    .numberOfEmployee(1)
                    .status(EStatus.ACTIVE)
                    .country("USA")
                    .build());

            companyList.add(Company.builder()
                    .name("Amazon")
                    .logo("https://asset.brandfetch.io/idawOgYOsG/idK5GFOo3t.png")
                    .numberOfEmployee(1)
                    .status(EStatus.ACTIVE)
                    .country("USA")
                    .build());

            companyList.add(Company.builder()
                    .name("Google")
                    .logo("https://asset.brandfetch.io/id6O2oGzv-/idSuJ5ik7i.png")
                    .numberOfEmployee(1)
                    .status(EStatus.ACTIVE)
                    .country("USA")
                    .build());

            companyList.add(Company.builder()
                    .name("Microsoft")
                    .logo("https://asset.brandfetch.io/idchmboHEZ/id-ypZheVL.png")
                    .numberOfEmployee(1)
                    .status(EStatus.ACTIVE)
                    .country("USA")
                    .build());

            companyList.add(Company.builder()
                    .name("Facebook")
                    .logo("https://asset.brandfetch.io/idpKX136kp/idQbJ8ZEuI.png")
                    .numberOfEmployee(1)
                    .status(EStatus.ACTIVE)
                    .country("USA")
                    .build());

            companyList.add(Company.builder()
                    .name("Twitter")
                    .logo("https://asset.brandfetch.io/idS5WhqBbM/idrn8jLjIE.png")
                    .numberOfEmployee(1)
                    .status(EStatus.ACTIVE)
                    .country("USA")
                    .build());

            companyList.add(Company.builder()
                    .name("Netflix")
                    .logo("https://asset.brandfetch.io/ideQwN5lBE/idAVFyOJN0.png")
                    .numberOfEmployee(1)
                    .status(EStatus.ACTIVE)
                    .country("USA")
                    .build());

            companyService.saveAll(companyList);
        }
    }


    // Feature demo data insertion
    private void insertFeatureDemoData() {
        if(featureService.getAll().isEmpty()) {
            List<Feature> featureList = new ArrayList<>();
            featureList.add(Feature.builder()
                    .name("Recruitment")
                    .iconPath("recruitment.png")
                    .shortDescription("Manage your recruitment processes from a single platform.")
                    .build());

            featureList.add(Feature.builder()
                    .name("Performance")
                    .iconPath("performance.png")
                    .shortDescription("Involve employees in online performance appraisal.")
                    .build());

            featureList.add(Feature.builder()
                    .name("Shift")
                    .iconPath("shift.png")
                    .shortDescription("Plan and manage your working time in the most efficient way.")
                    .build());

            featureList.add(Feature.builder()
                    .name("Wage Evaluation")
                    .iconPath("salary.png")
                    .shortDescription("Update, manage and report employee salaries.")
                    .build());

            featureList.add(Feature.builder()
                    .name("HR Analytics")
                    .iconPath("analytics.png")
                    .shortDescription("Track your instant HR data on a single platform, make data-driven decisions.")
                    .build());

            featureList.add(Feature.builder()
                    .name("Staff")
                    .iconPath("staff.png")
                    .shortDescription("Manage all employee information in one application.")
                    .build());
            featureList.add(Feature.builder()
                    .name("High Data Security")
                    .iconPath("data_security.png")
                    .shortDescription("Ensure the utmost security of your data with Easy HR.").build());

            featureList.add(Feature.builder()
                    .name("Flexible Pricing")
                    .iconPath("pricing.png")
                    .shortDescription("Choose from a variety of packages tailored to your company's size and needs.").build());

            featureList.add(Feature.builder()
                    .name("Easy Access Support")
                    .iconPath("support.png")
                    .shortDescription("Easily access support for any inquiries or issues.").build());

            featureService.saveAll(featureList);
        }
    }


    // Comment demo data insertion
    private void insertCommentDemoData() {
        List<Comment> commentList = new ArrayList<>();
        createManagerUser();
        User manager = userService.findByEmail("manager").orElseThrow(() -> new RuntimeException("Manager not found"));
        commentList.add(Comment.builder()
                        .companyId(manager.getCompanyId())
                        .managerId(manager.getId())
                        .shortDescription("A platform that can be easily used by employees of all levels, where HR processes can be managed smoothly and independently of the person")
                        .longDescription("Before we met Easy HR, we were having great difficulties with expense and leave tracking. In addition, our personal information was managed in an irregular way in different Google documents.\n" +
                                "\n" +
                                "While looking for a digital HR solution to solve these problems, I discovered Easy HR on the recommendation of a friend. I had the opportunity to examine the application in detail during the demo period. Turkish and English language support and ease of use were very effective in our decision to cooperate.\n" +
                                "\n" +
                                "At the beginning, our biggest concern was the problems that may be experienced in keeping leave and expenses retrospectively and possible disruptions in approval processes. As we approach our first year of using Easy, we have not encountered any problems about these issues.\n" +
                                "\n" +
                                "A platform that can be easily used by employees of all levels, where HR processes can be managed smoothly and independently of the person\n" +
                                "\n" +
                                "With Easy HR, our expense processes have been streamlined and payment periods have been standardised. Employees are also very satisfied with this transition. The ease of request and approval processes in Easy HR enabled them to easily follow the transactions.\n" +
                                "\n" +
                                "I would definitely recommend Easy HR to other sector leaders. It is a platform that employees of all levels can easily adapt and use, and HR processes can be managed smoothly and independently of the person.\n" +
                                "\n")

                .build());
        User manager2 = userService.findByEmail("manager2@gmail.com").orElseThrow(() -> new RuntimeException("Manager not found"));
        commentList.add(Comment.builder()
                .companyId(manager2.getCompanyId())
                .managerId(manager2.getId())
                .shortDescription("Before we met Easy HR, we were very primitive in terms of personnel and leave management compared to today.")
                        .longDescription("Before we met Easy HR, we were very primitive in personnel and leave management compared to today.\n" +
                                "\n" +
                                "Before we met Easy, even accessing the simplest personal data took a very serious amount of time. Our leave management processes were manual and very error-prone. It took us a lot of time to meet the requests for information, statistical data, etc. from employees, management and related institutions. Our access to information was very limited and we did not have a database. Frankly speaking, we were very primitive in personnel and leave management compared to today.\n" +
                                "\n" +
                                "I had used Easy HR for a short period in my previous company and found it very useful. In addition, I started to follow its social accounts and HR magazine İKahve. It seemed very practical to manage personnel data and leave processes on a single platform. Moreover, the fact that there are many different applications and solution partners in the field of HR that we can use over time was very effective in our decision to cooperate.\n" +
                                "\n" +
                                "At the beginning, our biggest concern was whether our demands that would be shaped over time would be responded to accurately and quickly. However, we saw that this concern was very unfounded. :) For 10 months we have been actively using EasyEasy HR and during this time we had many requests that we insisted on. We would like to thank the entire Easy HR team for supporting us patiently and with open communication every time.\n" +
                                "\n")

                .build());
        User manager3 = userService.findByEmail("manager3@gmail.com").orElseThrow(() -> new RuntimeException("Manager not found"));
        commentList.add(Comment.builder()
                .companyId(manager3.getCompanyId())
                .managerId(manager3.getId())
                .shortDescription("We have experienced an evolution from disorder to order in our human resources processes with Easy HR!")
                        .longDescription("We have experienced an evolution from disorganisation to order in our human resources processes with Easy HR! \u200D\n" +
                                "\n" +
                                "Before we met Easy HR, especially our leave and expenditure processes were very complex and disorganised. The follow-up and control problems we experienced in these areas made us feel like we were constantly failing. \n" +
                                "\n" +
                                "Therefore, in 2016, we decided that we needed a solution to support our HR processes and we met Easy HR Personnel Management application. The features offered by the application for our problems were the most important factors affecting our decision to cooperate.\n" +
                                "\n" +
                                "Before starting to work with Easy HR, our biggest concern was the loss of time that switching to such a software would create. However, Easy HR's flexible structure and customer-oriented approach eliminated all these concerns.\n" +
                                "\n" +
                                "After we started using Easy HR, the features we benefited the most were leave and expenditure. The control mechanisms in these processes and access to historical data have greatly facilitated our work. We have experienced an evolution from disorder to order in our human resources processes with Easy. It has been really great to be able to access historical data and see the big picture!")


                .build());
        commentService.saveAll(commentList);
    }

    private void insertHolidayDemoData() {
        List <Holiday> holidayList = new ArrayList<>();

        holidayList.add(Holiday.builder()
                .holidayName("29 EKİM")
                .holidayType(EHolidayType.NATIONAL)
                .holidayStartDate(1730182819L)
                .holidayEndDate(1730269219L)
                .build());

        holidayList.add(Holiday.builder()
                .holidayName("KURBAN BAYRAMI")
                .holidayType(EHolidayType.RELIGIOUS)
                .holidayStartDate(1749190819L)
                .holidayEndDate(1749450019L)
                .build());

        holidayList.add(Holiday.builder()
                .holidayName("RAMAZAN BAYRAMI")
                .holidayType(EHolidayType.RELIGIOUS)
                .holidayStartDate(1743315619L)
                .holidayEndDate(1743488419L)
                .build());

        holidayList.add(Holiday.builder()
                .holidayName("YILBAŞI")
                .holidayType(EHolidayType.INTERNATIONAL)
                .holidayStartDate(1735626019L)
                .holidayEndDate(1735712419L)
                .build());

        holidayList.add(Holiday.builder()
                .holidayName("23 NİSAN")
                .holidayType(EHolidayType.NATIONAL)
                .holidayStartDate(1745389219L)
                .holidayEndDate(1745475619L)
                .build());

        holidayList.add(Holiday.builder()
                .holidayName("30 AĞUSTOS")
                .holidayType(EHolidayType.NATIONAL)
                .holidayStartDate(1756534819L)
                .holidayEndDate(1756621219L)
                .build());

        holidayList.add(Holiday.builder()
                .holidayName("1 MAYIS")
                .holidayType(EHolidayType.NATIONAL)
                .holidayStartDate(1746080419L)
                .holidayEndDate(1746166819L)
                .build());

        holidayService.saveAll(holidayList);
    }

    private void createManagerUser()
    {
        String managerEmail = "manager";
        String password = "123";

        if (authService.findByEmail(managerEmail).isEmpty())
        {
            String encodedPassword = passwordEncoder.bCryptPasswordEncoder().encode(password);

            Auth auth = authService.save(Auth.
                    builder()
                    .status(EStatus.ACTIVE)
                    .email(managerEmail)
                    .password(encodedPassword)
                    .userType(EUserType.MANAGER)
                            .subscriptionType(ESubscriptionType.MONTHLY)
                    .build());


            User user = User
                    .builder()
                    .status(EStatus.ACTIVE)
                    .email(managerEmail)
                    .name("Snovid")
                    .surname("Sibiga")
                    .authId(auth.getId())
                    .subscriptionType(ESubscriptionType.MONTHLY)
                    .subscriptionStartDate(auth.getSubscriptionStartDate())
                    .subscriptionEndDate(auth.getSubscriptionEndDate())
                    .location("Turkey")
                    .birthDate(LocalDate.of(1989, 1, 1))
                    .position(EPosition.CARTOGRAPHER)
                    .companyId(1L)
                    .phone("5555555555")
                    .photo("https://xsgames.co/randomusers/assets/avatars/male/38.jpg")
                    .userType(EUserType.MANAGER)
                    .sector(ESectors.TECHNOLOGY)
                    .title("Turkey Operations Manager")
                    .build();
            userService.save(user);



            Auth auth2 = authService.save(Auth.
                    builder()
                    .status(EStatus.ACTIVE)
                    .email("manager2@gmail.com")
                    .password(encodedPassword)
                    .userType(EUserType.MANAGER)
                    .subscriptionType(ESubscriptionType.MONTHLY)
                    .build());


            User user2 = User
                    .builder()
                    .status(EStatus.ACTIVE)
                    .email(auth2.getEmail())
                    .name("Emir")
                    .surname("Güngördü")
                    .authId(auth2.getId())
                    .subscriptionType(ESubscriptionType.MONTHLY)
                    .subscriptionStartDate(auth2.getSubscriptionStartDate())
                    .subscriptionEndDate(auth2.getSubscriptionEndDate())
                    .location("Turkey")
                    .birthDate(LocalDate.of(1989, 1, 1))
                    .position(EPosition.CARTOGRAPHER)
                    .companyId(2L)
                    .phone("5555555555")
                    .photo("https://xsgames.co/randomusers/assets/avatars/male/34.jpg")
                    .userType(EUserType.MANAGER)
                    .sector(ESectors.TECHNOLOGY)
                    .title("CEO")
                    .build();
            userService.save(user2);

            Auth auth3 = authService.save(Auth.
                    builder()
                    .status(EStatus.ACTIVE)
                    .email("manager3@gmail.com")
                    .password(encodedPassword)
                    .userType(EUserType.MANAGER)
                    .subscriptionType(ESubscriptionType.MONTHLY)
                    .build());


            User user3 = User
                    .builder()
                    .status(EStatus.ACTIVE)
                    .email(auth3.getEmail())
                    .name("Aslan")
                    .surname("Demir")
                    .authId(auth3.getId())
                    .subscriptionType(ESubscriptionType.MONTHLY)
                    .subscriptionStartDate(auth3.getSubscriptionStartDate())
                    .subscriptionEndDate(auth3.getSubscriptionEndDate())
                    .location("Turkey")
                    .birthDate(LocalDate.of(1989, 1, 1))
                    .position(EPosition.CARTOGRAPHER)
                    .companyId(3L)
                    .phone("5555555555")
                    .photo("https://xsgames.co/randomusers/assets/avatars/male/39.jpg")
                    .userType(EUserType.MANAGER)
                    .sector(ESectors.TECHNOLOGY)
                    .title("General Manager")
                    .build();
            userService.save(user3);

            Auth auth4 = authService.save(Auth.
                    builder()
                    .status(EStatus.ACTIVE)
                    .email("manager4@gmail.com")
                    .password(encodedPassword)
                    .userType(EUserType.MANAGER)
                    .subscriptionType(ESubscriptionType.MONTHLY)
                    .build());


            User user4 = User
                    .builder()
                    .status(EStatus.ACTIVE)
                    .email(auth4.getEmail())
                    .name("Can")
                    .surname("Kara")
                    .authId(auth4.getId())
                    .subscriptionType(ESubscriptionType.MONTHLY)
                    .subscriptionStartDate(auth4.getSubscriptionStartDate())
                    .subscriptionEndDate(auth4.getSubscriptionEndDate())
                    .location("Turkey")
                    .birthDate(LocalDate.of(1989, 1, 1))
                    .position(EPosition.CARTOGRAPHER)
                    .companyId(10L)
                    .phone("5555555555")
                    .photo("https://xsgames.co/randomusers/assets/avatars/male/31.jpg")
                    .userType(EUserType.MANAGER)
                    .sector(ESectors.TECHNOLOGY)
                    .title("CEO")
                    .build();
            userService.save(user4);

            // Adding employee to the manager
            Auth authEmployee = authService.save(Auth.
                    builder()
                    .status(EStatus.ACTIVE)
                    .email("employee")
                    .password(encodedPassword)
                    .userType(EUserType.EMPLOYEE)
                    .subscriptionType(ESubscriptionType.MONTHLY)
                    .build());

            User employee = User
                    .builder()
                    .status(EStatus.ACTIVE)
                    .email("employee")
                    .name("Employee 1")
                    .surname("Hard")
                    .managerId(user.getId())
                    .authId(authEmployee.getId())
                    .subscriptionType(ESubscriptionType.MONTHLY)
                    .subscriptionStartDate(authEmployee.getSubscriptionStartDate())
                    .subscriptionEndDate(authEmployee.getSubscriptionEndDate())
                    .location("Turkey")
                    .birthDate(LocalDate.of(1999, 4, 1))
                    .position(EPosition.ADMINISTRATIVE_ASSISTANT)
                    .companyId(1L)
                    .phone("5555555555")
                    .photo("https://t4.ftcdn.net/jpg/03/64/21/11/360_F_364211147_1qgLVxv1Tcq0Ohz3FawUfrtONzz8nq3e.jpg")
                    .userType(EUserType.EMPLOYEE)
                    .employeeType(EEmployeeType.FULL_TIME)
                    .sector(ESectors.TECHNOLOGY)
                    .title("Turkey Operations Employee")
                    .hireDate(LocalDate.of(2021, 1, 1))

                    .build();
            userService.save(employee);

            Auth authEmployee2 = authService.save(Auth.
                    builder()
                    .status(EStatus.ACTIVE)
                    .email("employee2")
                    .password(encodedPassword)
                    .userType(EUserType.EMPLOYEE)
                    .subscriptionType(ESubscriptionType.MONTHLY)
                    .build());

            User employee2 = User
                    .builder()
                    .status(EStatus.ACTIVE)
                    .email("employee2")
                    .name("Ahmet")
                    .surname("Kaya")
                    .managerId(user.getId())
                    .authId(authEmployee2.getId())
                    .subscriptionType(ESubscriptionType.MONTHLY)
                    .subscriptionStartDate(authEmployee.getSubscriptionStartDate())
                    .subscriptionEndDate(authEmployee.getSubscriptionEndDate())
                    .location("Turkey")
                    .birthDate(LocalDate.of(1990, 5, 15))
                    .position(EPosition.COMPUTER_PROGRAMMER)
                    .companyId(1L)
                    .phone("5555555555")
                    .photo("https://t4.ftcdn.net/jpg/03/64/21/11/360_F_364211147_1qgLVxv1Tcq0Ohz3FawUfrtONzz8nq3e.jpg")
                    .userType(EUserType.EMPLOYEE)
                    .employeeType(EEmployeeType.PART_TIME)
                    .sector(ESectors.TECHNOLOGY)
                    .title("Dr.")
                    .hireDate(LocalDate.of(2023, 5, 5))

                    .build();
            userService.save(employee2);

            Optional<Company> company = companyService.findById(1L);
            company.get().setNumberOfEmployee(3);
            companyService.update(company.get());

        }
    }


    private void instertOfferDemoData()
    {


        offerService.save(new OfferSaveRequestDto(
                "Alice",
                "Johnson",
                "alice.johnson@example.com",
                "111111111",
                "Tech Corp",
                "Backend Developer",
                "8",
                ESectors.TECHNOLOGY
        ));

        offerService.save(new OfferSaveRequestDto(
                "Bob",
                "Smith",
                "bob.smith@example.com",
                "222222222",
                "Creative Studio",
                "Graphic Designer",
                "5",
                ESectors.AGRICULTURAL_SERVICES
        ));

        offerService.save(new OfferSaveRequestDto(
                "Charlie",
                "Brown",
                "charlie.brown@example.com",
                "333333333",
                "Health Solutions",
                "Nurse",
                "12",
                ESectors.HEALTHCARE
        ));

        offerService.save(new OfferSaveRequestDto(
                "David",
                "Clark",
                "david.clark@example.com",
                "444444444",
                "Finance World",
                "Financial Analyst",
                "7",
                ESectors.ACCOUNTING_SERVICES
        ));

        offerService.save(new OfferSaveRequestDto(
                "Eva",
                "Martin",
                "eva.martin@example.com",
                "555555555",
                "Marketing Pro",
                "Marketing Manager",
                "9",
                ESectors.MARKETING
        ));

        offerService.save(new OfferSaveRequestDto(
                "Frank",
                "Garcia",
                "frank.garcia@example.com",
                "666666666",
                "Eco Energy",
                "Environmental Engineer",
                "6",
                ESectors.CONSTRUCTION
        ));

        offerService.save(new OfferSaveRequestDto(
                "Grace",
                "Lee",
                "grace.lee@example.com",
                "777777777",
                "Retail Masters",
                "Store Manager",
                "11",
                ESectors.RETAIL
        ));

        offerService.save(new OfferSaveRequestDto(
                "Hank",
                "Moore",
                "hank.moore@example.com",
                "888888888",
                "Edu Innovators",
                "Teacher",
                "10",
                ESectors.EDUCATION
        ));

        offerService.save(new OfferSaveRequestDto(
                "Ivy",
                "Taylor",
                "ivy.taylor@example.com",
                "999999999",
                "Construction Hub",
                "Civil Engineer",
                "8",
                ESectors.CONSTRUCTION
        ));

        offerService.save(new OfferSaveRequestDto(
                "Jack",
                "Anderson",
                "jack.anderson@example.com",
                "101010101",
                "Legal Experts",
                "Lawyer",
                "15",
                ESectors.LEGAL
        ));

        offerService.save(new OfferSaveRequestDto(
                "Kate",
                "Thomas",
                "kate.thomas@example.com",
                "202020202",
                "Foodie World",
                "Chef",
                "5",
                ESectors.INVESTMENT_MANAGEMENT
        ));

        offerService.save(new OfferSaveRequestDto(
                "Leo",
                "Martinez",
                "leo.martinez@example.com",
                "303030303",
                "Travel Bliss",
                "Travel Agent",
                "7",
                ESectors.JOURNALISM
        ));

        offerService.save(new OfferSaveRequestDto(
                "Mia",
                "Harris",
                "mia.harris@example.com",
                "404040404",
                "Auto Experts",
                "Automotive Technician",
                "6",
                ESectors.AUTOMOTIVE
        ));

        offerService.save(new OfferSaveRequestDto(
                "Noah",
                "Nelson",
                "noah.nelson@example.com",
                "505050505",
                "Media World",
                "Journalist",
                "9",
                ESectors.MEDIA
        ));

        offerService.save(new OfferSaveRequestDto(
                "Olivia",
                "Scott",
                "olivia.scott@example.com",
                "606060606",
                "Beauty Bliss",
                "Cosmetologist",
                "10",
                ESectors.TOURISM
        ));


    }
}
