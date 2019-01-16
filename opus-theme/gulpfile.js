const { task, src, series, dest } = require('gulp');
const { typographist, ratios } = require('typographist');
const postcss = require('gulp-postcss');

const processors = [
    typographist({
        base: '16px',
        lineHeight: 1.4,
        ratio: ratios.MINOR_SECOND,
        tablet: {
            breakpoint: '768px',
            base: '17px',
            ratio: ratios.MAJOR_SECOND,
        },
        desktop: {
            breakpoint: '992px',
            base: '18px',
            ratio: ratios.MINOR_THIRD,
        },
        lgDesktop: {
            breakpoint: '1200px',
            base: '20px',
        },
    })
];

task('styles', () =>
    src('./src/*.css')
        .pipe(postcss(processors))
        .pipe(dest('./target/www')));

task('statics', () =>
    src('./src/*.html')
        .pipe(dest("./target/www")));

task('scripts', () =>
    src('./src/*.js')
        .pipe(dest("./target/www")));

task('default', series('styles', 'statics', 'scripts'), done => {
    done();
});
