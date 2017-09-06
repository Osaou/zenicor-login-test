/*(function () {

    window.addEventListener('load', () => {
        const form = document.querySelector('form')
        const loginUrl = form.getAttribute('action')

        form.addEventListener('submit', e => {
            e.preventDefault()
            e.stopImmediatePropagation()

            document.querySelector('h1').innerText = 'oh, cool'

            const user = form.querySelector('input[name=user]').value
            const pass = form.querySelector('input[name=pass]').value
            if (!user || !pass) {
                return
            }

            const request = new Request(loginUrl, {
                method: 'POST',
                body: new FormData(form),
            	headers: new Headers({
            		'Content-Type': 'application/json'
            	})
            })

            fetch(request)
                .then(res => res.json())
                .then(json => {
                    if (json.success)
                        location.reload(true)
                })
                .catch(e => console.log(e))
        })
    })

})()*/

$(() => {
    $('form').submit(e => {
        //e.preventDefault()

        const user = $('input[name=user]').val()
        const pass = $('input[name=pass]').val()

        if (!user || !pass) {
            e.preventDefault()
            return
        }

        /*$.ajax({
            type: 'POST',
            url: '/login',
            data: { user, pass }
        })
        .done(data => {
            location.reload(true)
        })
        .fail(e => {
            console.log('noes', e)
        })*/
    })
})
