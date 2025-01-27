@import exercise.dto.users.UserPage
@param UserPage page

<html>
    <head>
        <title>User</title>
    </head>
    <body>
        @if(page.getUser() == null)
            <p>Пока не добавлено ни одного курса</p>
        @else
            <div>
                <h2>${page.getUser().getFirstName()}</h2>
                <p>${page.getUser().getLastName()}</p>
                <p>${page.getUser().getEmail()}</p>
            </div>
        @endif
    </body>
</html>