# VACCINE SLOT NOTIFIER

    This is a spring boot REST application basically built to fetch the vaccination slot details from public APIs provided by the API Setu.


        # API Details

            1. /api/check-status - [GET] - This end-point is used to check the status of the application. If the application is running, this end-point will return a string value "app running...".

            2. /api/master/states - [GET] - This end-point will return all the states in India.

            3. /api/master/districts/{stateId} - [GET] - This end-point will return all the district under a particular state.

            4. /api/sessions/findByDateAndDistrict - [GET]  - This end-point will return the slot details for the particular date under a particular district. Query param required (i) districtId - Integer, (ii) date - String (dd-MM-yyyy).

            5. /api/sessions/findWeeklySlotAvailability - [GET] - This end-point will return the slot details for a week from the given date under a particular district. Query param required (i) districtId - Integer, (ii) date - String (dd-MM-yyyy).

    Anyone can fork this app and customize as per the requirement. Suggestions are also accepted. Since this is an experimental project, the code quality and code efficiency might not be that much good. I'll be keep updating the code.