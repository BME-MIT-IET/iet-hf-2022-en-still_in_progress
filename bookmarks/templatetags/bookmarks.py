from django import template

from bookmarks.forms import BookmarkForm

register = template.Library()


@register.inclusion_tag('bookmarks/form.html', name='bookmark_form')
def bookmark_form(form: BookmarkForm):
    return {
        'form': form,
    }
