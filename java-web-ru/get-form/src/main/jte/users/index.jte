@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
    content = @`
        <form action="/users" method="get">
          <input type="search" required name="term">
          <input type="submit" value="Искать">
        </form>
        <h1>Пользователи</h1>
        <table class="table table-striped">
            @for(var user : page.getUsers())
                <tr>
                    <td>
                        ${user.getId()}
                    </td>
                    <td>
                        <p>${user.getFirstName()} ${user.getLastName()}</p>
                    </td>
                </tr>
            @endfor
        </table>
    `,
    footer = @`
        <p>Thanks for visiting, come again soon!</p>
    `
)