
$(() => {
    $('form').submit(e => {
        const name = $('input[name=name]').val();
        const pass = $('input[name=pass]').val();

        if (!name || !pass) {
            e.preventDefault();
            return;
        }
    });
});
